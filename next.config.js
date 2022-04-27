const webpack = require("webpack");
const moduleExports = {
  inlineImageLimit: 20480,
  webpack: (config, { isServer }) => {
    config.plugins.push(
      new webpack.DefinePlugin({
        __SERVER__: isServer,
      })
    );
    config.module.rules.push(
      // {
      //   issuer: {
      //     // nextjs already handles url() in css/sass/scss files
      //     test: /\.\w+(?<!(s?c|sa)ss)$/i,
      //   },
      //   test: /\.(jpe?g|png|gif|svg)$/i,
      //   use: [
      //     {
      //       loader: "url-loader",
      //       options: {
      //         esModule: false,
      //         limit: 10240,
      //         name: "[name]_[hash:base64:5].[ext]",
      //         outputPath: "static/images/",
      //       }
      //     }
      //   ]
      // },
    );
    return config;
  },
  // assetPrefix: "",
  publicRuntimeConfig: {
    kenv: "",
  },
};

module.exports = moduleExports;

