const spawn = require('child_process').spawn;
const chalk = require("chalk");

module.exports = async function (cwd, callback, executable = 'npm', args = ['start']) {
    console.log(chalk.greenBright("正在运行项目……\n"));
    // 执行executable args 对应到默认参数即 npm start 安装依赖
    await new Promise((resolve, reject) => {
        const installProcess =
            spawn(executable, args, { cwd: cwd, stdio: "inherit", shell: true });
        //文件目录， 继承父进程的输入输出【即控制台可以看到子进程输出】，开启shell 
        installProcess.on('exit', () => {
            console.log(chalk.greenBright("依赖安装完成!"));
            resolve();
        });
        installProcess.on('error', (err) => {
            console.log(chalk.red("依赖安装失败"));
            reject(err);
        })
    }).then(() => { callback(); })
        .catch((err) => { console.log(chalk.red("出现错误")); console.log(err) });

}