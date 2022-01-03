package io.michaelrocks.libphonenumber.android;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class Phonemetadata$PhoneNumberDesc implements Externalizable {
    public boolean c;
    public boolean y;
    public String d = "";
    public List<Integer> q = new ArrayList();
    public List<Integer> x = new ArrayList();
    public String Y1 = "";

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        if (objectInput.readBoolean()) {
            String readUTF = objectInput.readUTF();
            this.c = true;
            this.d = readUTF;
        }
        int readInt = objectInput.readInt();
        for (int i = 0; i < readInt; i++) {
            this.q.add(Integer.valueOf(objectInput.readInt()));
        }
        int readInt2 = objectInput.readInt();
        for (int i2 = 0; i2 < readInt2; i2++) {
            this.x.add(Integer.valueOf(objectInput.readInt()));
        }
        if (objectInput.readBoolean()) {
            String readUTF2 = objectInput.readUTF();
            this.y = true;
            this.Y1 = readUTF2;
        }
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeBoolean(this.c);
        if (this.c) {
            objectOutput.writeUTF(this.d);
        }
        int size = this.q.size();
        objectOutput.writeInt(size);
        for (int i = 0; i < size; i++) {
            objectOutput.writeInt(this.q.get(i).intValue());
        }
        int size2 = this.x.size();
        objectOutput.writeInt(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            objectOutput.writeInt(this.x.get(i2).intValue());
        }
        objectOutput.writeBoolean(this.y);
        if (this.y) {
            objectOutput.writeUTF(this.Y1);
        }
    }
}
