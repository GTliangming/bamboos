const download = require('download-git-repo')
const path = require('path')
const ora = require('ora')
const logSymbols = require("log-symbols");
const chalk = require("chalk");
const CONST = require('../utils/conf')
const Spinnies = require("spinnies")
module.exports = function (target, url, branch, projectName) {
    // const spinner = ora(`正在下载项目模板，源地址：${url}#${branch}`)
    // target = path.join(CONST.TEMPLATE_NAME)
    // spinner.start()
    // return new Promise((resolve, reject) => {
    //     download(`direct:${url}#${branch}`,
    //         target, { clone: true }, (err) => {
    //             if (err) {
    //                 spinner.fail()
    //                 console.log(logSymbols.fail, chalk.red("模板下载失败:("));
    //                 reject(err)
    //             } else {
    //                 spinner.succeed()
    //                 console.log(logSymbols.success, chalk.green("模板下载完毕:)"));
    //                 resolve(target)
    //             }
    //         })
    // })


    const spinner = { interval: 80, frames: ['🍇', '🍈', '🍉', '🍋'] }
    const spinnies = new Spinnies({ color: 'blue', succeedColor: 'green', spinner });
    spinnies.add('spinner-1', { text: `正在下载项目模板，源地址：${url}#${branch}` });
    target = path.join(projectName)
    return new Promise((resolve, reject) => {
        download(`direct:${url}#${branch}`,
            target, { clone: true }, (err) => {
                if (err) {
                    spinnies.fail('spinner-1', { text: "模板下载失败  🍇", successColor: 'redBright' });
                    reject(err)
                } else {
                    spinnies.succeed('spinner-1', { text: "模板下载完毕    🍋", successColor: 'greenBright' });
                    resolve(target)
                }
            })
    })
}