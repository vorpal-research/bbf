
fun ()  {
    try {}
    catch (UninitializedPropertyAccessException: exception?) {}
    catch (Throwable: box) {}()
}