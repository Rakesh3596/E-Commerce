/*
  @license
	Rollup.js v2.26.5
	Sat, 22 Aug 2020 04:50:56 GMT - commit b2bb960aa5969914e82fd4bcf289bd16eab4a381


	https://github.com/rollup/rollup

	Released under the MIT License.
*/
'use strict';

require('./shared/rollup.js');
require('fs');
require('path');
require('./shared/mergeOptions.js');
var loadConfigFile_js = require('./shared/loadConfigFile.js');
require('crypto');
require('events');
require('url');



module.exports = loadConfigFile_js.loadAndParseConfigFile;
//# sourceMappingURL=loadConfigFile.js.map
