fun 
()  {
try {}
catch (e: UninitializedPropertyAccessException) {
         "Unexpected exception: $e::class"
    }()
}
