fun 
()  {
    try {}
    catch (UninitializedPropertyAccessException: e) {}
    catch (e: exception?) {}()
}
