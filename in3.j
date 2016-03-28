.class public In3
.super java/lang/Object

.field private static msg Ljava/lang/String;
.field private static msg2 Ljava/lang/String;
.field private static filename Ljava/lang/String;
.field private static s Ljava/lang/String;
.field private static i I

.method public <init>()V

	aload_0
	invokenonvirtual	java/lang/Object/<init>()V
	return

.limit locals 1
.limit stack 1
.end method

.method public static main([Ljava/lang/String;)V

    ldc "This data comes from the Wikipedia page for Java Bytecode."
    astore 1
    ldc "There are a lot of rows in this table,\nso we will grab every fifth one for a total of 10."
    astore 2
    ldc "https://en.wikipedia.org/wiki/Java_bytecode_instruction_listings"
    astore 3
    ldc ""
    astore 4
    ldc 5
    putstatic In3/i I
L1:
    getstatic In3/i I
    ldc 55
    if_icmple    L2
    goto  L3
L2:
    aload 3
    ldc 1
    getstatic In3/i I
    ldc 1
    invokestatic wci/backend/JSOUP/getData(Ljava/lang/String;III)Ljava/lang/String;
    astore 4
    getstatic     java/lang/System/out Ljava/io/PrintStream;
    getstatic In3/i I
    invokestatic     java/lang/String.valueOf(I)Ljava/lang/String;
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    getstatic     java/lang/System/out Ljava/io/PrintStream;
    aload 4
    invokevirtual java/io/PrintStream.println(Ljava/lang/String;)V
    getstatic In3/i I
    ldc 5
    iadd
    putstatic In3/i I
    goto  L1
L3:


    return

.limit locals 5
.limit stack  16
.end method
