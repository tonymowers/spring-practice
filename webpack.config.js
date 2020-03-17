const path = require('path');
const target = path.resolve(__dirname, 'target/classes/static');

module.exports = {
    mode: 'development',
    optimization: {
        minimize: false //Update this to true or false
    },
    entry: './src/frontend/index.ts',
    devServer: {
        contentBase: target,
        port: 9000,
        proxy: {
            '/api': 'http://localhost:8080'
        }
    },
    module: {
        rules: [
            {
                test: /\.tsx?$/,
                use: 'ts-loader',
                exclude: /node_modules/,
            },
            {
                test: /\.(s*)css$/,
                use: ['style-loader', 'css-loader', 'sass-loader']
            },
            {
                test: /\.(png|svg|jpg|gif)$/,
                use: [
                    'file-loader'
                ],
            },
        ],
    },
    resolve: {
        extensions: [ '.tsx', '.ts', '.js' ],
    },
    output: {
        filename: 'bundle.js',
        path: target,
    },

};