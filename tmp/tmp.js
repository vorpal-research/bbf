const kotlin = require("/home/stepanov/Kotlin/bbf/tmp/lib//kotlin.js");

if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'tmp'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'tmp'.");
}
var tmp = function (_, Kotlin) {
  'use strict';
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var ensureNotNull = Kotlin.ensureNotNull;
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  var Array_0 = Array;
  function A() {
  }
  function A$B(i) {
    this.i = i;
  }
  A$B.prototype.toString = function () {
    var res = '';
    return res;
  };
  A$B.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'B',
    interfaces: []
  };
  A.prototype.test = function () {
    var array = Array_0(-1956034648);
    var tmp$;
    tmp$ = array.length - 1 | 0;
    for (var i = 0; i <= tmp$; i++) {
      array[i] = new A$B(i);
    }
    return array;
  };
  A.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'A',
    interfaces: []
  };
  function box() {
    if (ensureNotNull((new A()).test()[5]).i === 996761328) {
      println('THEN');
      return 'OK';
    }
     else {
      println('ELSE');
      return 'fail';
    }
  }
  function main(args) {
    println(box());
  }
  A.B = A$B;
  _.A = A;
  _.box = box;
  _.main_kand9s$ = main;
  main([]);
  Kotlin.defineModule('tmp', _);
  return _;
}(typeof tmp === 'undefined' ? {} : tmp, kotlin);
