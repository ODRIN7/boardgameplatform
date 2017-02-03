const path = require('path');
const webpack = require('webpack');

const port = process.env.PORT || 3000;

const entries = [
  'src/main/frontend/src/main.tsx'
];


module.exports = {
  devtool: 'source-map',
  entry: entries,
  output: {
    path: path.join(__dirname, 'src/main/resources/templates/public/dist/'),
    filename: 'bundle.js',
    publicPath: '/dist/'
  },
  plugins: [
    new webpack.DefinePlugin({
      'process.env': {
        'NODE_ENV': JSON.stringify('production'),
      },
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
        loader: 'tslint',
        include: path.join(__dirname, 'src/main/frontend/src')
      }
    ],
    loaders: [
      {
        test: /\.less$/,
        loader: 'style!css!less',
        include: path.join(__dirname, 'src/main/frontend/src/styles')
      },
      {
        test: /\.(png|jpg)$/,
        loader: 'url?limit=25000',
      },
      {
        test: /\.(eot|svg|ttf|woff|woff2)$/,
        loader: 'file?name=public/fonts/[name].[ext]'
      },

      {
        test: /\.tsx?$/,
        loader: 'babel!ts',
        include: path.join(__dirname, 'src/main/frontend/src')
      }
    ]
  },
  tslint: {
    emitErrors: true,
    failOnHint: true
  }
};
