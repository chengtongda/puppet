#!/bin/bash

typeset PUPPET_FILE="puppet.zip";

echo "Download... puppet.zip";
curl -sLk "http://puppet.oss-cn-hangzhou.aliyuncs.com/puppet.zip?file=puppet.zip" -o $PUPPET_FILE;
if [[ ! $? -eq  0 ]]; then
    echo "download file failed!";
    exit -1;
fi 

unzip $PUPPET_FILE
rm -rf $PUPPET_FILE
chmod +x puppet/cssh
chmod +x puppet/init_user

./puppet/init_user

echo "done. enjoy yourself.^_^"
