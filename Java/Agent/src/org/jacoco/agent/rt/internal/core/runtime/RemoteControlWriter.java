/*    */ package org.jacoco.agent.rt.internal_8ff85ea.core.runtime;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import org.jacoco.agent.rt.internal_8ff85ea.core.data.ExecutionDataWriter;
/*    */ import org.jacoco.agent.rt.internal_8ff85ea.core.internal.data.CompactDataOutput;
/*    */ 
/*    */ public class RemoteControlWriter extends ExecutionDataWriter
/*    */   implements IRemoteCommandVisitor
/*    */ {
/*    */   public static final byte BLOCK_CMDOK = 32;
/*    */   public static final byte BLOCK_CMDDUMP = 64;
/*    */ 
/*    */   public RemoteControlWriter(OutputStream output)
/*    */     throws IOException
/*    */   {
/* 40 */     super(output);
/*    */   }
/*    */ 
/*    */   public void sendCmdOk()
/*    */     throws IOException
/*    */   {
/* 51 */     this.out.writeByte(32);
/*    */   }
/*    */ 
/*    */   public void visitDumpCommand(boolean dump, boolean reset) throws IOException
/*    */   {
/* 56 */     this.out.writeByte(64);
/* 57 */     this.out.writeBoolean(dump);
/* 58 */     this.out.writeBoolean(reset);
/*    */   }
/*    */ }

/* Location:           C:\Users\zqj\Desktop\jacocoant.src\jacocoagent.jar
 * Qualified Name:     org.jacoco.agent.rt.internal_8ff85ea.core.runtime.RemoteControlWriter
 * JD-Core Version:    0.5.4
 */