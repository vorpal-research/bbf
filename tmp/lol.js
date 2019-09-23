const kotlin = require("/home/stepanov/Kotlin/bbf/tmp/lib//kotlin.js");

if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'lol'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'lol'.");
}
var lol = function (_, Kotlin) {
  'use strict';
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_287e2$;
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function box() {
    var l = ArrayList_init();
    l.add_11rb$(true);
    var x = !l.get_za3lpa$(-2117618646);
    if (x) {
      println('THEN');
      return 'Fail: ' + x + '}';
    }
    return 'bniwh';
  }
  function main(args) {
    println(box());
  }
  _.box = box;
  _.main_kand9s$ = main;
  main([]);
  Kotlin.defineModule('lol', _);
  return _;
}(typeof lol === 'undefined' ? {} : lol, kotlin);
