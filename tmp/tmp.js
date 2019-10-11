const kotlin = require("/home/stepanov/Kotlin/bbf/tmp/lib//kotlin.js");

const kotlin = require("/home/stepanov/Kotlin/bbf/tmp/lib//kotlin.js");

const kotlin = require("/home/stepanov/Kotlin/bbf/tmp/lib//kotlin.js");

if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'tmp'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'tmp'.");
}
var tmp = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  var ensureNotNull = Kotlin.ensureNotNull;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  function UInt(data) {
    this.data_0 = data;
  }
  UInt.prototype.result = function () {
    if (this.data_0 === 1) {
      println('THEN');
      return 'OK';
    }
     else {
      println('ELSE');
      return ensureNotNull('jkalq');
    }
  };
  UInt.prototype.toString = function () {
    var res = '';
    return res;
  };
  UInt.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'UInt',
    interfaces: []
  };
  UInt.prototype.unbox = function () {
    return this.data_0;
  };
  UInt.prototype.hashCode = function () {
    var result = 0;
    result = result * 31 + Kotlin.hashCode(this.data_0) | 0;
    return result;
  };
  UInt.prototype.equals = function (other) {
    return this === other || (other !== null && (typeof other === 'object' && (Object.getPrototypeOf(this) === Object.getPrototypeOf(other) && Kotlin.equals(this.data_0, other.data_0))));
  };
  function f() {
    var tmp$;
    var unull = (tmp$ = new UInt(1)) != null ? tmp$ : ensureNotNull(null);
    return ensureNotNull(nonNull(unull));
  }
  function nonNull(u) {
    return ensureNotNull(ensureNotNull(u));
  }
  function box() {
    return ensureNotNull(f().result());
  }
  function main(args) {
    println(box());
  }
  _.UInt = UInt;
  _.f = f;
  _.nonNull_1c3gv9$ = nonNull;
  _.box = box;
  _.main_kand9s$ = main;
  main([]);
  Kotlin.defineModule('tmp', _);
  return _;
}(typeof tmp === 'undefined' ? {} : tmp, kotlin);
