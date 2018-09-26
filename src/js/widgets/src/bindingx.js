import { parse } from 'bindingx-parser'
import _cloneDeep from 'lodash/cloneDeep'

const WeexBinding = weex.requireModule('bindingx')
const BindingxFunction = WeexBinding.bind

let _WeexBinding = _cloneDeep(WeexBinding)
let Bindingx = Object.create(null)

// 重写 bind 方法
_WeexBinding.bind = (options, callback) => {
    if (!options) {
        throw new Error('should pass options for binding')
    }

    options.exitExpression = formatExpression(options.exitExpression)

    if (options.props) {
        options.props.forEach((prop) => {
            prop.expression = formatExpression(prop.expression)
        })
    }

    return BindingxFunction(options, options && options.eventType === 'timing' ? fixCallback(callback) : callback)
}

Bindingx.install = (Vue, options) => {
    Vue.prototype.$bindingx = _WeexBinding
}

const formatExpression = (expression) => {
    if (expression === undefined) return
    try {
        expression = JSON.parse(expression)
    } catch (err) {

    }
    let resultExpression = {}
    if (typeof expression === 'string') {
        resultExpression.origin = expression
    } else if (expression) {
        resultExpression.origin = expression.origin
        resultExpression.transformed = expression.transformed
    }
    if (!resultExpression.transformed && !resultExpression.origin) return
    resultExpression.transformed = resultExpression.transformed || parse(resultExpression.origin)
    return resultExpression
}

const fixCallback = (callback) => {
    return function(params = {}) {
        if (typeof callback === 'function') {
            return callback({
                state: params.state === 'end' ? 'exit' : params.state,
                t: params.t !== undefined ? params.t : params.deltaT
            })
        }
    }
}

Vue.use(Bindingx)
