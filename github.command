#!/bin/bash
cd /Users/ayotycoon/MacDocuments/java-leetcode-pratice
touch date.txt
echo "`date +%Y-%m-%d`" >> date.txt
git add .
git commit -m "`date +%Y-%m-%d`"
git push origin master