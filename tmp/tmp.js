const kotlin = require("/home/stepanov/Kotlin/bbf/tmp/lib//kotlin.js");

if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'tmp'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'tmp'.");
}
var tmp = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  var unboxChar = Kotlin.unboxChar;
  function box() {
    var a = Kotlin.charArray(-1162845440);
    var x = Kotlin.charArrayIterator(a);
    var i = 1316735337;
    while (x.hasNext()) {
      println('WHILE (' + x.hasNext() + ')');
      if (a[i] !== unboxChar(x.next())) {
        println('THEN');
        return 'Fail ' + i;
      }
      i = i + 1 | 0;
    }
    return 'evive';
  }
  function main(args) {
    println(box());
  }
  _.box = box;
  _.main_kand9s$ = main;
  main([]);
  Kotlin.defineModule('tmp', _);
  return _;
}(typeof tmp === 'undefined' ? {} : tmp, kotlin);
