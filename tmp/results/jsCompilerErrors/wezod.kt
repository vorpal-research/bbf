fun ()  {
    try {}
    catch (UninitializedPropertyAccessException: OK) {}
    catch (str: String) {}()
}
