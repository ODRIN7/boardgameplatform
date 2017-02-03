const path = require('path');
const webpack = require('webpack');

const port = process.env.PORT || 3000;

const entries = [
  'webpack-dev-server/client?http://localhost:' + port,
  'webpack/hot/only-dev-server',
  'react-hot-loader/patch',
  './src/main/frontend/src/main.tsx'
];


module.exports = {
  devtool: 'source-map',
  entry: entries,
  loader: 'style-loader',
  output: {
    path: path.join(__dirname, 'src/main/resources/static/public/dist'),
    filename: 'bundle.js',
    publicPath: '/'
    /* redbox-react/README.md */
    // ,devtoolModuleFilenameTemplate: '/[absolute-resource-path]'
  },
  plugins: [
    new webpack.HotModuleReplacementPlugin(),
    new webpack.DefinePlugin({
      __API_SERVER_URL__: JSON.stringify('http://localhost:8080')
    })
  ],
  resolve: {
    extensions: ['', '.ts', '.tsx', '.js']
  },
  resolveLoader: {
    'fallback': path.join(__dirname, 'node_modules')
  },
  module: {
    preLoaders: [
      {
        test: /\.tsx?$/,
        loader: 'tslint'
      }
    ],
    loaders: [
      {
        test: /\.css$/,
        loader: 'style!css'
      },
      {
        test: /\.less$/,
        loader: 'style!css!less'
      },
      {
        test: /\.(png|jpg)$/,
        loader: 'url?limit=25000'
      },
      {
        test: /\.(eot|svg|ttf|woff|woff2)$/,
        loader: 'file?name=public/fonts/[name].[ext]'
      },

      {
        test: /\.tsx?$/,
        loader: 'babel!ts'
      }
    ]
  },
  tslint: {
    emitErrors: true,
    failOnHint: true
  }
};
