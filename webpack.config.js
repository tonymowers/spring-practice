const path = require('path');

module.exports = {
    mode: 'development',
    optimization: {
        minimize: false //Update this to true or false
    },
    entry: {
        app: './src/frontend/index.ts',
        adminApp: './src/frontend/admin.ts'
    },
    devServer: {
        contentBase: path.resolve(__dirname, 'target/classes/static'),
        port: 9000,
        proxy: {
            '/api': 'http://localhost:8080/api'
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
                loader: 'file-loader'
            },
            {
                test: /\.(html)$/,
                loader: 'file-loader',
                options: {
                    regExp: /([a-z0-9]+)\.html$/i,
                    name: '[1].html',
                },
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            }
        ],
    },
    resolve: {
        alias: {
            'vue$': 'vue/dist/vue.esm.js'
        },
        extensions: [ '.tsx', '.ts', '.js' ],
    },
    output: {
        filename: '[name].js',
        path: path.resolve(__dirname, 'target/classes/static'),
        libraryTarget: 'var',
        library: 'EntryPoint'
    },

};