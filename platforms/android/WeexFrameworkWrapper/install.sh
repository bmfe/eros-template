#!/usr/bin/env bash
echo "开始更新依赖库"
rm -r wxframework/
rm -r nexus/

git clone https://github.com/bmfe/WeexErosFramework.git "wxframework" --depth=1

git clone https://github.com/bmfe/eros-nexus.git "nexus" --depth=1

cd ../

echo "依赖库更新完成"
