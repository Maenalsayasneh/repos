package io.michaelrocks.libphonenumber.android;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class Phonemetadata$NumberFormat implements Externalizable {
    public boolean Z1;
    public boolean x;
    public String c = "";
    public String d = "";
    public List<String> q = new ArrayList();
    public String y = "";
    public boolean Y1 = false;
    public String a2 = "";

    public int a() {
        return this.q.size();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        this.c = objectInput.readUTF();
        this.d = objectInput.readUTF();
        int readInt = objectInput.readInt();
        for (int i = 0; i < readInt; i++) {
            this.q.add(objectInput.readUTF());
        }
        if (objectInput.readBoolean()) {
            String readUTF = objectInput.readUTF();
            this.x = true;
            this.y = readUTF;
        }
        if (objectInput.readBoolean()) {
            String readUTF2 = objectInput.readUTF();
            this.Z1 = true;
            this.a2 = readUTF2;
        }
        this.Y1 = objectInput.readBoolean();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeUTF(this.c);
        objectOutput.writeUTF(this.d);
        int a = a();
        objectOutput.writeInt(a);
        for (int i = 0; i < a; i++) {
            objectOutput.writeUTF(this.q.get(i));
        }
        objectOutput.writeBoolean(this.x);
        if (this.x) {
            objectOutput.writeUTF(this.y);
        }
        objectOutput.writeBoolean(this.Z1);
        if (this.Z1) {
            objectOutput.writeUTF(this.a2);
        }
        objectOutput.writeBoolean(this.Y1);
    }
}
