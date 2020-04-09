var common = [
    '--require-module tsconfig-paths/register',
    '--require-module ts-node/register',
    '--require src/frontend/features/support/env.js',
    '--require src/frontend/features/**/*.ts',
    '--tags @frontend',
    '  src/test/resources/features/**/*.feature'
].join(' ')

module.exports = {
    default: common,
}