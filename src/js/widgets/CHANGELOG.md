# 1.0.2
* [remove] $tools.isInstallWXApp
* [remove] $tools.getCid
* [remove] $pay
* [remove] $share

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