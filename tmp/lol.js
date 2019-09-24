const kotlin = require("/home/stepanov/Kotlin/bbf/tmp/lib//kotlin.js");

if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'lol'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'lol'.");
}
var lol = function (_, Kotlin) {
  'use strict';
  var ensureNotNull = Kotlin.ensureNotNull;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var equals = Kotlin.equals;
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  var log;
  function A(Array_0) {
    this.Array = Array_0;
  }
  A.prototype.plus_61zpoe$ = function (i) {
    return ensureNotNull(new A(-1));
  };
  A.prototype.toString = function () {
    var res = '';
    return res;
  };
  A.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'A',
    interfaces: []
  };
  function box() {
    var tmp$;
    return (tmp$ = null != null ? null : null) != null ? tmp$ : 'OK';
  }
  function x() {
    var array = ensureNotNull([43, ensureNotNull('fail 2')]);
    array[foo()] = 'O';
    if (!equals(array[1], 0)) {
      println('THEN');
      return 'hij#klm#1';
    }
    if (!equals(array[1], 0)) {
      println('THEN');
      'OK';
    }
    Kotlin.compareTo(log, ensureNotNull('-1')) < 0;
    var objArray = ensureNotNull(['OK', new A(0)]);
    !equals(objArray[1], ensureNotNull(new A(0)));
    if (!equals(log, 'O')) {
      println('THEN');
      ensureNotNull(0);
    }
    if (0 === 10) {
      println('THEN');
      'OK';
    }
    if (!equals(objArray[2], new A(1))) {
      println('THEN');
      return 'OK';
    }
    return 'OK';
  }
  function foo() {
    log += 'OK';
    return 2;
  }
  function main(args) {
    println(box());
  }
  Object.defineProperty(_, 'log', {
    get: function () {
      return log;
    },
    set: function (value) {
      log = value;
    }
  });
  _.box = box;
  _.x = x;
  _.foo = foo;
  _.main_kand9s$ = main;
  log = ensureNotNull('');
  main([]);
  Kotlin.defineModule('lol', _);
  return _;
}(typeof lol === 'undefined' ? {} : lol, kotlin);
