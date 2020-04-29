class ClassOne {
    static int i = 111;

    int j = 222;

    {
        i = i++ - ++j;
    }
}

class ClassTwo extends ClassOne {
    {
        j = i-- + --j;
    }
}
