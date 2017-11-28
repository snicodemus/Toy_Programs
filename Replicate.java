class Replicate {
   String text[] = {
      "class Replicate {",
      "   String text[] = {",
      "   };",
      "   void quote(String s) {",
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
   void quote(String s) {
      System.out.print("      \"" + s.replace("\\", "\\\\").replace("\"", "\\\"") + "\"");
   }
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
      Replicate myProgram = new Replicate();
      myProgram.list();
   }
}
