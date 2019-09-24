
fun ()  {
    try {}
    catch (UninitializedPropertyAccessException: e) {}
    catch (str: OK) {}()
}