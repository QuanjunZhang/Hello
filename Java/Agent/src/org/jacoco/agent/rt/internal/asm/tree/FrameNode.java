/*     */ package org.jacoco.agent.rt.internal_8ff85ea.asm.tree;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.jacoco.agent.rt.internal_8ff85ea.asm.MethodVisitor;
/*     */ 
/*     */ public class FrameNode extends AbstractInsnNode
/*     */ {
/*     */   public int type;
/*     */   public List<Object> local;
/*     */   public List<Object> stack;
/*     */ 
/*     */   private FrameNode()
/*     */   {
/*  81 */     super(-1);
/*     */   }
/*     */ 
/*     */   public FrameNode(int type, int nLocal, Object[] local, int nStack, Object[] stack)
/*     */   {
/* 110 */     super(-1);
/* 111 */     this.type = type;
/* 112 */     switch (type)
/*     */     {
/*     */     case -1:
/*     */     case 0:
/* 115 */       this.local = asList(nLocal, local);
/* 116 */       this.stack = asList(nStack, stack);
/* 117 */       break;
/*     */     case 1:
/* 119 */       this.local = asList(nLocal, local);
/* 120 */       break;
/*     */     case 2:
/* 122 */       this.local = Arrays.asList(new Object[nLocal]);
/* 123 */       break;
/*     */     case 3:
/* 125 */       break;
/*     */     case 4:
/* 127 */       this.stack = asList(1, stack);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getType()
/*     */   {
/* 134 */     return 14;
/*     */   }
/*     */ 
/*     */   public void accept(MethodVisitor mv)
/*     */   {
/* 145 */     switch (this.type)
/*     */     {
/*     */     case -1:
/*     */     case 0:
/* 148 */       mv.visitFrame(this.type, this.local.size(), asArray(this.local), this.stack.size(), 
/* 149 */         asArray(this.stack));
/*     */ 
/* 150 */       break;
/*     */     case 1:
/* 152 */       mv.visitFrame(this.type, this.local.size(), asArray(this.local), 0, null);
/* 153 */       break;
/*     */     case 2:
/* 155 */       mv.visitFrame(this.type, this.local.size(), null, 0, null);
/* 156 */       break;
/*     */     case 3:
/* 158 */       mv.visitFrame(this.type, 0, null, 0, null);
/* 159 */       break;
/*     */     case 4:
/* 161 */       mv.visitFrame(this.type, 0, null, 1, asArray(this.stack));
/*     */     }
/*     */   }
/*     */ 
/*     */   public AbstractInsnNode clone(Map<LabelNode, LabelNode> labels)
/*     */   {
/* 168 */     FrameNode clone = new FrameNode();
/* 169 */     clone.type = this.type;
/* 170 */     if (this.local != null) {
/* 171 */       clone.local = new ArrayList();
/* 172 */       for (int i = 0; i < this.local.size(); ++i) {
/* 173 */         Object l = this.local.get(i);
/* 174 */         if (l instanceof LabelNode) {
/* 175 */           l = labels.get(l);
/*     */         }
/* 177 */         clone.local.add(l);
/*     */       }
/*     */     }
/* 180 */     if (this.stack != null) {
/* 181 */       clone.stack = new ArrayList();
/* 182 */       for (int i = 0; i < this.stack.size(); ++i) {
/* 183 */         Object s = this.stack.get(i);
/* 184 */         if (s instanceof LabelNode) {
/* 185 */           s = labels.get(s);
/*     */         }
/* 187 */         clone.stack.add(s);
/*     */       }
/*     */     }
/* 190 */     return clone;
/*     */   }
/*     */ 
/*     */   private static List<Object> asList(int n, Object[] o)
/*     */   {
/* 196 */     return Arrays.asList(o).subList(0, n);
/*     */   }
/*     */ 
/*     */   private static Object[] asArray(List<Object> l) {
/* 200 */     Object[] objs = new Object[l.size()];
/* 201 */     for (int i = 0; i < objs.length; ++i) {
/* 202 */       Object o = l.get(i);
/* 203 */       if (o instanceof LabelNode) {
/* 204 */         o = ((LabelNode)o).getLabel();
/*     */       }
/* 206 */       objs[i] = o;
/*     */     }
/* 208 */     return objs;
/*     */   }
/*     */ }

/* Location:           C:\Users\zqj\Desktop\jacocoant.src\jacocoagent.jar
 * Qualified Name:     org.jacoco.agent.rt.internal_8ff85ea.asm.tree.FrameNode
 * JD-Core Version:    0.5.4
 */