// This class is the same as replicate.java except that comments and whitespace // have been added. The purpose of the program is to make the output the same
// as the program itself, and this would be complicated greatly with comments.
// If this version is compiled and run, it will print the original program
// without the comments and blank lines.
//
// First, the program is essentially represented as an array. The code itself
// prints the first two lines of the array (which is also the first two lines
// of the program), repeatedly calls the quote() method to construct the lines
// contained in the array definition, then prints the remainder of the array
// (i.e. the rest of the program).
//
// The program was inspired by a rereading of Hoftstadter's Godel, Escher, Bach.

class ReplicateWithComments {
   // First, create an array that contains strings representing the program.
   String text[] = {
      "class Replicate {",
      "   String text[] = {",
      "   };",
      "   void quote(String s) {",

      // This is probably one of the most complicated lines in the program.
      // The quotes will be explained with the actual line in the code, but
      // of course here all the quotes and backslashes need another level of
      // quoting. For example, " in the program will be represented by \"
      // there, and by \\\" here.

      "      System.out.print(\"      \\\"\" + s.replace(\"\\\\\", \"\\\\\\\\\").replace(\"\\\"\", \"\\\\\\\"\") + \"\\\"\");",
      "   }",
      "   void list() {",
      "      for (int i = 0; i < 2; i++)",
      "         System.out.println(text[i]);",
      "      for (int i = 0; i < text.length; i++) {",
      "         quote(text[i]);",
      "         if (i < text.length - 1)",
      "            System.out.println(\",\");",
      "         else",
      "            System.out.println();",
      "      }",
      "      for (int i = 2; i < text.length; i++)",
      "         System.out.println(text[i]);",
      "   }",
      "   public static void main(String[] args) {",
      "      Replicate myProgram = new Replicate();",
      "      myProgram.list();",
      "   }",
      "}"
   };

   // This method reconstructs the lines inside the string array declaration.
   // As mentioned above, " in the program must be represented by \" here, and
   // \ in the program must be represented by \\ here. Half of the backslashes
   // here and in the corresponding line in the array are removed by the
   // compiler, so they have to be added back in.
   //
   void quote(String s) {
      System.out.print("      \"" + s.replace("\\", "\\\\").replace("\"", "\\\"") + "\"");
   }

   // This is the method that actually does the printing. It prints the first
   // two lines, repeatedly calls quote to reconstruct the strings in the array,
   // and then prints the rest of the program.

   void list() {
      for (int i = 0; i < 2; i++)
         System.out.println(text[i]);
      for (int i = 0; i < text.length; i++) {
         quote(text[i]);
         if (i < text.length - 1)
            System.out.println(",");
         else
            System.out.println();
      }
      for (int i = 2; i < text.length; i++)
         System.out.println(text[i]);
   }
 
   public static void main(String[] args) {
      ReplicateWithComments myProgram = new ReplicateWithComments();
      myProgram.list();
   }
}
