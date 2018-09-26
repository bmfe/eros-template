eros widget is the two encapsulation for eros module.

## How to use
1.install eros-widget in eros init project.
```
$ npm i eros-widget -S
```
2.init widget in appboard js bundle.(default: `config/index.js`)
``` js
import widget from 'eros-Widget'

const options = {}

new widget(options)
```

## Config options
```js
const options = {
    router: {
        /**
         * 路由配置表
         */
        routes: {}
    },
    ajax: {
        baseUrl: 'http://app.weex-eros.com:52077',
        /**
         * 接口别名
         */
        apis: {},
        // 接口超时时间
        timeout: 30000,

        /**
         * 请求发送统一拦截器 （可选）
         * options 你请求传入的所有参数和配置
         * next
         */
        requestHandler (options, next) {
            console.log('request-opts', options)
            next()
        },
        /**
         * 请求返回统一拦截器 （可选）
         * options 你请求传入的所有参数和配置
         * resData 服务器端返回的所有数据
         * resolve 请求成功请resolve你得结果，这样请求的.then中的成功回调就能拿到你resolve的数据
         * reject 请求成功请resolve你得结果，这样请求的.then中的失败回调就能拿到你reject的数据
         */
        responseHandler (options, resData, resolve, reject) {
            const { status, errorMsg, data } = resData
            if (status !== 200) {
                console.log(`invoke error status: ${status}`)
                console.log(`invoke error message: ${errorMsg}`)
                reject(resData)
            } else {
                // 自定义请求逻辑
                resolve(data)
            }
        }
    }
```

`router.routes`: config $router.open path alias
```js
routes: {
	'demo': {
        title: 'weex-eros demo',
        url: '/pages/demo/index.js'
    }
}
```

#### `ajax.baseUrl`: config you request baseUrl
#### `ajax.apis`: config you request path alias
```js
apis: {
    'COMMON.getInfo': '/test/info/'
}
```
 also you can config dynamic path.
```js
apis: {
    'COMMON.getInfo': '/test/info/{plaform}/{id}'
}
```
and we deliver them in $get/$post params option.
```js
this.$get({
    name: 'COMMON.getInfo',
    params: {
        platform: 'app',
        id: 3
    },
    data: {
        name: 'eros'
    }
})
```
finally our request url become :
```
ajax.baseUrl + /test/info/app/3?name=eros
```

#### `ajax.timeout`: request timeout time.(ms)
#### `ajax.requestHandler`: request Interceptor
#### `ajax.responseHandler`: response Interceptor

## How to develop

1.init eros project.

```
$ eros init
```

2.cd your project and enter src/js

```
$ cd eros-demo/src/js
```

3.clone eros-widget.git.
```
$ git clone https://github.com/bmfe/eros-widget.git eros-widget
```

4.add config `eros.dev.js` alias option.
```js
"ErosWidget": "js/eros-widget"
```

5.init widget in appboard js bundle.(default: `config/index.js`)
```js
import ErosWidget from 'ErosWidget'

const options = {}

new ErosWidget(options)
```

> welcome your pull request! eros loves you.

## Records
# 1.0.1-beta.8
* [bugfix] backAppeared 和 beforeBackAppeared 不执行的问题
* [bugfix] pickAndUpload 成功后成功回调进入 error 回调
* [optimize] fetch method GET POST 大小写均可

# 1.0.1-beta.7
* [bugfix] $image.upload status code 判断失误

# 1.0.1-beta.6
* [optimize] 重写 $bindingx 的引用方法，重写了 bind 方法，支持所有内部暴露出来的方法
* [bugfix] 父子组件同时注册生命周期，执行两次的 bug

# 1.0.1-beta.3/4/5
* [add] support bindingx.

# 1.0.1-beta.2
* [bugfix] beforeAppear 和 beforeBackAppear 另个页面返回或者结束后仍会获取到上次的$router.setBackParams数据的 bug.

# 1.0.1-beta.1
* [bugfix] 修复全局事件注册2次的bug

# 1.0.1
生命周期，自定义事件均做调整，如果不更改，请不要升级到 `1.0.1`。
* `bmRouter` 变更为 `eros`
* 添加 `pushMessage`，可在页面中监听推送
* 添加 `appActive`，可在页面中监听 app 切换到后台事件
* 添加 `appDeactive`，可在页面中监听 app 切换至前台事件
* `viewWillAppear` 变更为 `beforeAppear`，beforeBackAppear，通过打开类型来做区分
* `viewDidAppear` 变更为 `appeared`，`backAppeared`，通过打开类型来做区分
* `viewWillDisappear` 变更为 `beforeDisappear`
* `viewDidDisappear` 变更为 `disappeared`

# 1.0.0
* 从模板中抽离 widget 完成