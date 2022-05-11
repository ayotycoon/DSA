const path = require('path')
const fs = require('fs');

const relativeDir = './src/leetcode';
const dir = path.resolve(__dirname, relativeDir);

let totalJavaDone = 0; 
let totalPythonDone = 0; 

class LeetcodeFolder {
    number = 0;
    numberEndsLength = 0;
    folderName = "";
    relativeFolderPath = "";
    relativeReadMeFile = "";
    relativeJavaFile = "";
    relativePythonFile = ""
    javaDone = false;
    pythonDone= false;
    constructor(folderName) {
        this.folderName = folderName;
        this.relativeFolderPath = path.join(relativeDir, folderName);
        // extract number;
        let tempNo = ""

        for (let i = 0; i < folderName.length; i++) {
            if (!isNaN(folderName[i])) tempNo += folderName[i]; else break;
        }
        this.numberEndsLength = tempNo.length;
        this.number = parseInt(tempNo);
        // extract java files;
        const content = fs.readdirSync(this.relativeFolderPath);

        for (let file of content) {
            if (file.endsWith('.md'))this.relativeReadMeFile = path.join(this.relativeFolderPath, file);
            if (file.endsWith('.java')){
                this.relativeJavaFile = path.join(this.relativeFolderPath, file);
            if(fs.readFileSync(this.relativeJavaFile,{encoding:'utf-8'}).match(/(TestCaseExecutor)|(System\.out\.println)/))this.javaDone = true;
            if(this.javaDone)totalJavaDone++;
            }
            if (file.endsWith('.py')){
                this.relativePythonFile = path.join(this.relativeFolderPath, file);
                if(fs.readFileSync(this.relativePythonFile,{encoding:'utf-8'}).match(/print/))this.pythonDone = true;
                if(this.pythonDone)totalPythonDone++;
            }
        }
    }


}



const folders = fs.readdirSync(dir).filter(f => !isNaN(f[0]));

const arr = folders.map(f => new LeetcodeFolder(f)).sort((a, b) => a.number - b.number);



let readMe = `
# [LeetCode](https://leetcode.com/problemset/algorithms/) [![License](https://img.shields.io/badge/license-Apache_2.0-blue.svg)](LICENSE.md) 

_If you like this project, please leave me a star._ &#9733;

> ["For coding interview preparation, LeetCode is one of the best online resource providing a rich library of more than 300 real coding interview questions for you to practice from using one of the 7 supported languages - C, C++, Java, Python, C#, JavaScript, Ruby."](https://www.quora.com/How-effective-is-Leetcode-for-preparing-for-technical-interviews)

## Algorithms

Java ${Math.ceil((totalJavaDone / arr.length) * 100)} %\\
Python ${Math.ceil((totalPythonDone / arr.length) * 100)} %


| # |Name | Solutions |__|
|---|-----|-------|----|
`;

arr.forEach(clazz => {
    readMe += `|${clazz.number}|[${clazz.folderName.substring(clazz.numberEndsLength+1).replace(/_/g," ")}](${clazz.relativeFolderPath}) |[Java ${clazz.javaDone ? '✅': '❌'}](${clazz.relativeJavaFile}),[Python ${clazz.pythonDone ? '✅': '❌'}](${clazz.relativePythonFile})|__|
`
})


fs.writeFileSync('./README.md', readMe);


