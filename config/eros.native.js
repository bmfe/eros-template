module.exports = {
    'appName': 'eros-template-name',
    'appBoard': '/config/index.js',
    // android 监听全局事件homeBack 如果为true 安卓端需要自行调用router.finish方法来关闭应用
    'androidIsListenHomeBack': 'true',
    'customBundleUpdate': 'false',
    'version': {
        'android': 'eros-template-version',
        'iOS': 'eros-template-version'
    },
    'page': {
        'homePage': '/pages/hello.js',
        'mediatorPage': '/mediator/index.js',
        'navBarColor': '#1DA1F2',
        'navItemColor': '#ffffff'
    },
    'url': {
        'image': 'https://www.weex.eros/test/xxx',
        'bundleUpdate': 'http://localhosts:3001/app/check'
    },
    'zipFolder': {
        'iOS': '/ios/WeexEros/WeexEros',
        'android': '/android/WeexFrameworkWrapper/app/src/main/assets'
    },
    'getui': {
        'enabled': 'false',
        'appId': '',
        'appKey': '',
        'appSecret': ''
    },
    'tabBar': {
        'color': '#777777',
        'selectedColor': '#00b4cb',
        'backgroundColor': '#fafafa',
        'borderColor': '#dfe1eb',
        'list': [{
                'pagePath': '',
                'text': '',
                'icon': '',
                'selectedIcon': '',
                'navShow': 'false',
                'navTitle': ''
            },
            {
                'pagePath': '',
                'text': '',
                'icon': '',
                'selectedIcon': '',
                'navShow': '',
                'navTitle': ''
            },
            {
                'pagePath': '',
                'text': '',
                'icon': '',
                'selectedIcon': '',
                'navShow': 'false',
                'navTitle': ''
            }
        ]
    }
}