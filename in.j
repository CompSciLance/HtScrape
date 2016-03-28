.class public In
.super java/lang/Object

.field private static i I
.field private static test Ljava/lang/String;
.field private static f F
.field private static filename Ljava/lang/String;
.field private static i1 I
.field private static i2 I
.field private static iHope Ljava/lang/String;
.field private static s Ljava/lang/String;
.field private static t I
.field private static col I

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static main([Ljava/lang/String;)V

    ldc 3
    putstatic In/i I
    ldc "test"
    astore 2
    ldc 2.33
    putstatic In/f F
    ldc "https://en.wikipedia.org/wiki/Java_bytecode_instruction_listings"
    astore 4
    getstatic     java/lang/System/out Ljava/io/PrintStream;
    getstatic In/f F
    invokestatic     java/lang/String.valueOf(F)Ljava/lang/String;
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    getstatic In/i I
    ldc 0
    if_icmpeq    L1
    iconst_0
    goto  L2
L1:
    iconst_1
L2:
    ifeq   L3
    ldc "true"
    astore 2
    goto  L4
L3:
    ldc "false"
    astore 2
L4:
    getstatic     java/lang/System/out Ljava/io/PrintStream;
    aload 2
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    ldc 0
    putstatic In/i I
    getstatic In/i I
    ldc 0
    if_icmpne    L5
    iconst_0
    goto  L6
L5:
    iconst_1
L6:
    ifeq   L7
    getstatic     java/lang/System/out Ljava/io/PrintStream;
    aload 2
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    goto  L8
L7:
L8:
    ldc 2
    putstatic In/i1 I
    ldc 2
    putstatic In/i2 I
    ldc 2
    ldc 3
    iadd
    ldc 1
    isub
    putstatic In/i1 I
    ldc 2
    ldc 3
    imul
    ldc 3
    iadd
    putstatic In/i2 I
    getstatic In/f F
    ldc 4.56
    fadd
    putstatic In/f F
    ldc "I hope this works!"
    astore 7
    getstatic     java/lang/System/out Ljava/io/PrintStream;
    getstatic In/i1 I
    invokestatic     java/lang/String.valueOf(I)Ljava/lang/String;
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    getstatic     java/lang/System/out Ljava/io/PrintStream;
    getstatic In/i2 I
    invokestatic     java/lang/String.valueOf(I)Ljava/lang/String;
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    getstatic     java/lang/System/out Ljava/io/PrintStream;
    getstatic In/f F
    invokestatic     java/lang/String.valueOf(F)Ljava/lang/String;
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    ldc "test s"
    astore 8
    ldc 2
    putstatic In/i I
    ldc 1
    putstatic In/t I
    ldc 1
    putstatic In/col I
    aload 4
    getstatic In/t I
    getstatic In/i I
    getstatic In/col I
    invokestatic wci/backend/JSOUP/getData(Ljava/lang/String;III)Ljava/lang/String;
    astore 8
    getstatic     java/lang/System/out Ljava/io/PrintStream;
    aload 8
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    getstatic     java/lang/System/out Ljava/io/PrintStream;
    aload 7
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
L9:
    getstatic In/i I
    ldc 10
    if_icmplt    L10
    goto  L11
L10:
    getstatic     java/lang/System/out Ljava/io/PrintStream;
    getstatic In/i I
    invokestatic     java/lang/String.valueOf(I)Ljava/lang/String;
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    aload 4
    getstatic In/t I
    getstatic In/i I
    getstatic In/col I
    invokestatic wci/backend/JSOUP/printData(Ljava/lang/String;III)V
    getstatic In/i I
    ldc 1
    iadd
    putstatic In/i I
    goto  L9
L11:
    ldc 1
    putstatic In/i I


    return

.limit locals 10
.limit stack  16
.end method
