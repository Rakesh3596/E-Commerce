"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.getWorkspaceDetails = exports.insideWorkspace = void 0;
/**
 * @license
 * Copyright Google Inc. All Rights Reserved.
 *
 * Use of this source code is governed by an MIT-style license that can be
 * found in the LICENSE file at https://angular.io/license
 */
const core_1 = require("@angular-devkit/core");
const fs = require("fs");
const os = require("os");
const path = require("path");
const find_up_1 = require("./find-up");
function insideWorkspace() {
    return getWorkspaceDetails() !== null;
}
exports.insideWorkspace = insideWorkspace;
function getWorkspaceDetails() {
    const currentDir = process.cwd();
    const possibleConfigFiles = [
        'angular.json',
        '.angular.json',
        'angular-cli.json',
        '.angular-cli.json',
    ];
    const configFilePath = find_up_1.findUp(possibleConfigFiles, currentDir);
    if (configFilePath === null) {
        return null;
    }
    const configFileName = path.basename(configFilePath);
    const possibleDir = path.dirname(configFilePath);
    const homedir = os.homedir();
    if (core_1.normalize(possibleDir) === core_1.normalize(homedir)) {
        const packageJsonPath = path.join(possibleDir, 'package.json');
        if (!fs.existsSync(packageJsonPath)) {
            // No package.json
            return null;
        }
        const packageJsonBuffer = fs.readFileSync(packageJsonPath);
        const packageJsonText = packageJsonBuffer === null ? '{}' : packageJsonBuffer.toString();
        const packageJson = JSON.parse(packageJsonText);
        if (!containsCliDep(packageJson)) {
            // No CLI dependency
            return null;
        }
    }
    return {
        root: possibleDir,
        configFile: configFileName,
    };
}
exports.getWorkspaceDetails = getWorkspaceDetails;
function containsCliDep(obj) {
    var _a, _b;
    const pkgName = '@angular/cli';
    if (!obj) {
        return false;
    }
    return !!(((_a = obj.dependencies) === null || _a === void 0 ? void 0 : _a[pkgName]) || ((_b = obj.devDependencies) === null || _b === void 0 ? void 0 : _b[pkgName]));
}
