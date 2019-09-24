fun foo(block: (String, IllegalStateException, String) -> String): String = block("OK", "", "OK")

