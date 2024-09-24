// next.config.js
const path = require("path");

module.exports = {
  webpack: (config, { isServer }) => {
    config.resolve.alias["@"] = path.resolve(__dirname);
    return config;
  },
  pageExtensions: ["js", "jsx", "ts", "tsx"],
};
