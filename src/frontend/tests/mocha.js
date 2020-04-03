var common = [
    '--require-module tsconfig-paths/register',
    '--require-module ts-node/register',
    '  src/fontend/tests/**/*.test.ts'
].join(' ')

module.exports = {
    default: common,
}