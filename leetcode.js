const path = require('path')
const fs = require('fs');

const relativeDir = './src/leetcode';
const dir = path.resolve(__dirname, relativeDir);

class LeetcodeFolder {
    number = 0;
    folderName = "";
    relativeFolderPath = "";
    relativeReadMeFile = "";
    relativeJavaFile = "";
    relativePythonFile = ""
    constructor(folderName) {
        this.folderName = folderName;
        this.relativeFolderPath = path.join(relativeDir, folderName);
        // extract number;
        let tempNo = ""

        for (let i = 0; i < folderName.length; i++) {
            if (!isNaN(folderName[i])) tempNo += folderName[i]; else break;
        }
        this.number = parseInt(tempNo);
        // extract java files;
        const content = fs.readdirSync(this.relativeFolderPath);

        for (let file of content) {
            if (file.endsWith('.md'))this.relativeReadMeFile = path.join(this.relativeFolderPath, file);
            if (file.endsWith('.java'))this.relativeJavaFile = path.join(this.relativeFolderPath, file);
            if (file.endsWith('.py'))this.relativePythonFile = path.join(this.relativeFolderPath, file);
        }
    }


}



const folders = fs.readdirSync(dir).filter(f => !isNaN(f[0]));

const arr = folders.map(f => new LeetcodeFolder(f)).sort((a, b) => a.number - b.number);



let readMe = `
| Name | Files | -- |
| --- | --- | --- |
`;

arr.forEach(clazz => {
    readMe += `|[${clazz.folderName}](${clazz.relativeReadMeFile}) |[JAVA](${clazz.relativeJavaFile})<br/>[PYTHON](${clazz.relativePythonFile}) | -- |
`
})

fs.writeFileSync('./ReadME.md', readMe);


