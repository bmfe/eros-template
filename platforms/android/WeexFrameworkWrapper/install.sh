#!/usr/bin/env bash
echo "开始更新依赖库"
rm -r wxframework/
rm -r sdk/
rm -r nexus/

git clone https://github.com/bmfe/WeexErosFramework.git "wxframework"

git clone https://github.com/bmfe/eros-nexus.git "nexus"
cd ../

echo "依赖库更新完成"
