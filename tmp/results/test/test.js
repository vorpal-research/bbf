const kotlin = require("/home/stepanov/Kotlin/bbf/tmp/lib/kotlin.js");

if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'test'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'test'.");
}
var test = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function main() {
    while (true)
      println('Hey');
  }
  _.main = main;
  main();
  Kotlin.defineModule('test', _);
  return _;
}(typeof test === 'undefined' ? {} : test, kotlin);
