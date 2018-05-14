## eros 主项目地址
- [https://github.com/bmfe/eros](https://github.com/bmfe/eros)


## 介绍

> eros app 快速开发模板，可通过脚手架 eros-cli `init` 指令快速生成。

## 分支介绍

- master (附带着 demo 的完整开发底层)
- pure (无任何功能的纯净开发模板) `(开发中)`
- source (源码依赖分支 全插件 )

## 使用方法
#  Android 使用方法
* clone 此项目 然后切换到 suorce 分支。
* 执行platforms/android/WeexFrameworkWrapper 目录下 install.sh 文件 （下载依赖。）
* 运行项目即可
* 如果你不想使用某个插件 如：amap 你可以在 app 目录的 build.gradle 里删除 amap 依赖就可以
> compile project(':ErosPluginAmap') 即 amap 依赖，<br/>git clone https://github.com/bmfe/eros-template.git <br/> git checkout source <br/>sh install.sh
## 关于插件


