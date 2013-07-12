// Copyright 2013 Square, Inc.
package com.google.protobuf;

import com.squareup.protos.alltypes.AllTypes;
import com.squareup.protos.alltypes.Ext_all_types;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

public class TestAllTypes extends TestCase {

  // Return a two-element array with a given repeated value
  private <T> List<T> array(T x) {
    return Arrays.asList(x, x);
  }

  private final AllTypes allTypes = createAllTypes();
  private final Wire wire = new Wire(Ext_all_types.class);

  private AllTypes createAllTypes() {
    return getBuilder().build();
  }

  private AllTypes.Builder getBuilder() {
    byte[] bytes = { (byte) 125, (byte) 225 };
    AllTypes.NestedMessage nestedMessage = new AllTypes.NestedMessage.Builder().a(999).build();
    return new AllTypes.Builder()
        .opt_int32(111)
        .opt_uint32(112)
        .opt_sint32(113)
        .opt_fixed32(114)
        .opt_sfixed32(115)
        .opt_int64(116L)
        .opt_uint64(117L)
        .opt_sint64(118L)
        .opt_fixed64(119L)
        .opt_sfixed64(120L)
        .opt_bool(true)
        .opt_float(122.0F)
        .opt_double(123.0)
        .opt_string("124")
        .opt_bytes(bytes)
        .opt_nested_enum(AllTypes.NestedEnum.A)
        .opt_nested_message(nestedMessage)
        .req_int32(111)
        .req_uint32(112)
        .req_sint32(113)
        .req_fixed32(114)
        .req_sfixed32(115)
        .req_int64(116L)
        .req_uint64(117L)
        .req_sint64(118L)
        .req_fixed64(119L)
        .req_sfixed64(120L)
        .req_bool(true)
        .req_float(122.0F)
        .req_double(123.0)
        .req_string("124")
        .req_bytes(bytes)
        .req_nested_enum(AllTypes.NestedEnum.A)
        .req_nested_message(nestedMessage)
        .rep_int32(array(111))
        .rep_uint32(array(112))
        .rep_sint32(array(113))
        .rep_fixed32(array(114))
        .rep_sfixed32(array(115))
        .rep_int64(array(116L))
        .rep_uint64(array(117L))
        .rep_sint64(array(118L))
        .rep_fixed64(array(119L))
        .rep_sfixed64(array(120L))
        .rep_bool(array(true))
        .rep_float(array(122.0F))
        .rep_double(array(123.0))
        .rep_string(array("124"))
        .rep_bytes(array(bytes))
        .rep_nested_enum(array(AllTypes.NestedEnum.A))
        .rep_nested_message(array(nestedMessage))
        .pack_int32(array(111))
        .pack_uint32(array(112))
        .pack_sint32(array(113))
        .pack_fixed32(array(114))
        .pack_sfixed32(array(115))
        .pack_int64(array(116L))
        .pack_uint64(array(117L))
        .pack_sint64(array(118L))
        .pack_fixed64(array(119L))
        .pack_sfixed64(array(120L))
        .pack_bool(array(true))
        .pack_float(array(122.0F))
        .pack_double(array(123.0))
        .pack_string(array("124"))
        .pack_bytes(array(bytes))
        .pack_nested_enum(array(AllTypes.NestedEnum.A))
        .pack_nested_message(array(nestedMessage))
        .setExtension(Ext_all_types.ext_opt_bool, true)
        .setExtension(Ext_all_types.ext_rep_bool, array(true))
        .setExtension(Ext_all_types.ext_pack_bool, array(true));
  }

  @Test
  public void testHashCodes() {
    assertEquals(0, Wire.hashCode((byte[]) null));
    assertEquals(0, Wire.hashCode((List<byte[]>) null));

    AllTypes.Builder builder = getBuilder();
    AllTypes message = builder.build();
    int messageHashCode = message.hashCode();
    assertEquals(allTypes.hashCode(), messageHashCode);
  }

  @Test
  public void testBuilder() {
    AllTypes.Builder builder = getBuilder();
    AllTypes.NestedMessage nestedMessage = new AllTypes.NestedMessage.Builder().a(999).build();

    assertEquals(new Integer(111), builder.opt_int32);
    assertEquals(new Integer(112), builder.opt_uint32);
    assertEquals(new Integer(113), builder.opt_sint32);
    assertEquals(new Integer(114), builder.opt_fixed32);
    assertEquals(new Integer(115), builder.opt_sfixed32);
    assertEquals(new Long(116L), builder.opt_int64);
    assertEquals(new Long(117L), builder.opt_uint64);
    assertEquals(new Long(118L), builder.opt_sint64);
    assertEquals(new Long(119L), builder.opt_fixed64);
    assertEquals(new Long(120L), builder.opt_sfixed64);
    assertEquals(Boolean.TRUE, builder.opt_bool);
    assertEquals(new Float(122.0F), builder.opt_float);
    assertEquals(new Double(123.0), builder.opt_double);
    assertEquals("124", builder.opt_string);
    assertEquals(2, builder.opt_bytes.length);
    assertEquals((byte) 125, builder.opt_bytes[0]);
    assertEquals((byte) 225, builder.opt_bytes[1]);
    assertEquals(AllTypes.NestedEnum.A, builder.opt_nested_enum);
    assertEquals(nestedMessage, builder.opt_nested_message);

    assertEquals(new Integer(111), builder.req_int32);
    assertEquals(new Integer(112), builder.req_uint32);
    assertEquals(new Integer(113), builder.req_sint32);
    assertEquals(new Integer(114), builder.req_fixed32);
    assertEquals(new Integer(115), builder.req_sfixed32);
    assertEquals(new Long(116L), builder.req_int64);
    assertEquals(new Long(117L), builder.req_uint64);
    assertEquals(new Long(118L), builder.req_sint64);
    assertEquals(new Long(119L), builder.req_fixed64);
    assertEquals(new Long(120L), builder.req_sfixed64);
    assertEquals(Boolean.TRUE, builder.req_bool);
    assertEquals(new Float(122.0F), builder.req_float);
    assertEquals(new Double(123.0), builder.req_double);
    assertEquals("124", builder.req_string);
    assertEquals(2, builder.req_bytes.length);
    assertEquals((byte) 125, builder.req_bytes[0]);
    assertEquals((byte) 225, builder.req_bytes[1]);
    assertEquals(AllTypes.NestedEnum.A, builder.req_nested_enum);
    assertEquals(nestedMessage, builder.req_nested_message);

    assertEquals(2, builder.rep_int32.size());
    assertEquals(new Integer(111), builder.rep_int32.get(0));
    assertEquals(new Integer(111), builder.rep_int32.get(1));
    assertEquals(2, builder.rep_uint32.size());
    assertEquals(new Integer(112), builder.rep_uint32.get(0));
    assertEquals(new Integer(112), builder.rep_uint32.get(1));
    assertEquals(2, builder.rep_sint32.size());
    assertEquals(new Integer(113), builder.rep_sint32.get(0));
    assertEquals(new Integer(113), builder.rep_sint32.get(1));
    assertEquals(2, builder.rep_fixed32.size());
    assertEquals(new Integer(114), builder.rep_fixed32.get(0));
    assertEquals(new Integer(114), builder.rep_fixed32.get(1));
    assertEquals(2, builder.rep_sfixed32.size());
    assertEquals(new Integer(115), builder.rep_sfixed32.get(0));
    assertEquals(new Integer(115), builder.rep_sfixed32.get(1));
    assertEquals(2, builder.rep_int64.size());
    assertEquals(new Long(116L), builder.rep_int64.get(0));
    assertEquals(new Long(116L), builder.rep_int64.get(1));
    assertEquals(2, builder.rep_uint64.size());
    assertEquals(new Long(117L), builder.rep_uint64.get(0));
    assertEquals(new Long(117L), builder.rep_uint64.get(1));
    assertEquals(2, builder.rep_sint64.size());
    assertEquals(new Long(118L), builder.rep_sint64.get(0));
    assertEquals(new Long(118L), builder.rep_sint64.get(1));
    assertEquals(2, builder.rep_fixed64.size());
    assertEquals(new Long(119L), builder.rep_fixed64.get(0));
    assertEquals(new Long(119L), builder.rep_fixed64.get(1));
    assertEquals(2, builder.rep_sfixed64.size());
    assertEquals(new Long(120L), builder.rep_sfixed64.get(0));
    assertEquals(new Long(120L), builder.rep_sfixed64.get(1));
    assertEquals(2, builder.rep_bool.size());
    assertEquals(Boolean.TRUE, builder.rep_bool.get(0));
    assertEquals(Boolean.TRUE, builder.rep_bool.get(1));
    assertEquals(2, builder.rep_float.size());
    assertEquals(new Float(122.0F), builder.rep_float.get(0));
    assertEquals(new Float(122.0F), builder.rep_float.get(1));
    assertEquals(2, builder.rep_double.size());
    assertEquals(new Double(123.0), builder.rep_double.get(0));
    assertEquals(new Double(123.0), builder.rep_double.get(1));
    assertEquals(2, builder.rep_string.size());
    assertEquals("124", builder.rep_string.get(0));
    assertEquals("124", builder.rep_string.get(1));
    assertEquals(2, builder.rep_bytes.size());
    assertEquals(2, builder.rep_bytes.get(0).length);
    assertEquals((byte) 125, builder.rep_bytes.get(0)[0]);
    assertEquals((byte) 225, builder.rep_bytes.get(0)[1]);
    assertEquals(2, builder.rep_bytes.get(1).length);
    assertEquals((byte) 125, builder.rep_bytes.get(1)[0]);
    assertEquals((byte) 225, builder.rep_bytes.get(1)[1]);
    assertEquals(2, builder.rep_nested_enum.size());
    assertEquals(AllTypes.NestedEnum.A, builder.rep_nested_enum.get(0));
    assertEquals(AllTypes.NestedEnum.A, builder.rep_nested_enum.get(1));
    assertEquals(2, builder.rep_nested_message.size());
    assertEquals(nestedMessage, builder.rep_nested_message.get(0));
    assertEquals(nestedMessage, builder.rep_nested_message.get(1));

    assertEquals(2, builder.pack_int32.size());
    assertEquals(new Integer(111), builder.pack_int32.get(0));
    assertEquals(new Integer(111), builder.pack_int32.get(1));
    assertEquals(2, builder.pack_uint32.size());
    assertEquals(new Integer(112), builder.pack_uint32.get(0));
    assertEquals(new Integer(112), builder.pack_uint32.get(1));
    assertEquals(2, builder.pack_sint32.size());
    assertEquals(new Integer(113), builder.pack_sint32.get(0));
    assertEquals(new Integer(113), builder.pack_sint32.get(1));
    assertEquals(2, builder.pack_fixed32.size());
    assertEquals(new Integer(114), builder.pack_fixed32.get(0));
    assertEquals(new Integer(114), builder.pack_fixed32.get(1));
    assertEquals(2, builder.pack_sfixed32.size());
    assertEquals(new Integer(115), builder.pack_sfixed32.get(0));
    assertEquals(new Integer(115), builder.pack_sfixed32.get(1));
    assertEquals(2, builder.pack_int64.size());
    assertEquals(new Long(116L), builder.pack_int64.get(0));
    assertEquals(new Long(116L), builder.pack_int64.get(1));
    assertEquals(2, builder.pack_uint64.size());
    assertEquals(new Long(117L), builder.pack_uint64.get(0));
    assertEquals(new Long(117L), builder.pack_uint64.get(1));
    assertEquals(2, builder.pack_sint64.size());
    assertEquals(new Long(118L), builder.pack_sint64.get(0));
    assertEquals(new Long(118L), builder.pack_sint64.get(1));
    assertEquals(2, builder.pack_fixed64.size());
    assertEquals(new Long(119L), builder.pack_fixed64.get(0));
    assertEquals(new Long(119L), builder.pack_fixed64.get(1));
    assertEquals(2, builder.pack_sfixed64.size());
    assertEquals(new Long(120L), builder.pack_sfixed64.get(0));
    assertEquals(new Long(120L), builder.pack_sfixed64.get(1));
    assertEquals(2, builder.pack_bool.size());
    assertEquals(Boolean.TRUE, builder.pack_bool.get(0));
    assertEquals(Boolean.TRUE, builder.pack_bool.get(1));
    assertEquals(2, builder.pack_float.size());
    assertEquals(new Float(122.0F), builder.pack_float.get(0));
    assertEquals(new Float(122.0F), builder.pack_float.get(1));
    assertEquals(2, builder.pack_double.size());
    assertEquals(new Double(123.0), builder.pack_double.get(0));
    assertEquals(new Double(123.0), builder.pack_double.get(1));
    assertEquals(2, builder.pack_string.size());
    assertEquals("124", builder.pack_string.get(0));
    assertEquals("124", builder.pack_string.get(1));
    assertEquals(2, builder.pack_bytes.size());
    assertEquals(2, builder.pack_bytes.get(0).length);
    assertEquals((byte) 125, builder.pack_bytes.get(0)[0]);
    assertEquals((byte) 225, builder.pack_bytes.get(0)[1]);
    assertEquals(2, builder.pack_bytes.get(1).length);
    assertEquals((byte) 125, builder.pack_bytes.get(1)[0]);
    assertEquals((byte) 225, builder.pack_bytes.get(1)[1]);
    assertEquals(2, builder.pack_nested_enum.size());
    assertEquals(AllTypes.NestedEnum.A, builder.pack_nested_enum.get(0));
    assertEquals(AllTypes.NestedEnum.A, builder.pack_nested_enum.get(1));
    assertEquals(2, builder.pack_nested_message.size());
    assertEquals(nestedMessage, builder.pack_nested_message.get(0));
    assertEquals(nestedMessage, builder.pack_nested_message.get(1));

    assertEquals(Boolean.TRUE, builder.getExtension(Ext_all_types.ext_opt_bool));
    assertEquals(array(true), builder.getExtension(Ext_all_types.ext_rep_bool));
    assertEquals(array(true), builder.getExtension(Ext_all_types.ext_pack_bool));

    builder.setExtension(Ext_all_types.ext_opt_bool, false);
    builder.setExtension(Ext_all_types.ext_rep_bool, array(false));
    builder.setExtension(Ext_all_types.ext_pack_bool, array(false));

    assertEquals(Boolean.FALSE, builder.getExtension(Ext_all_types.ext_opt_bool));
    assertEquals(array(false), builder.getExtension(Ext_all_types.ext_rep_bool));
    assertEquals(array(false), builder.getExtension(Ext_all_types.ext_pack_bool));
  }

  @Test
  public void testInitBuilder() {
    AllTypes.Builder builder = new AllTypes.Builder(allTypes);
    assertEquals(allTypes, builder.build());
    builder.opt_bool = false;
    assertNotSame(allTypes, builder.build());
  }

  @Test
  public void testWrite() {
    int len = wire.getSerializedSize(allTypes);
    assertEquals(TestAllTypesData.expectedOutput.length, len);
    byte[] output = new byte[len];
    wire.writeTo(allTypes, output, 0, len);
    for (int i = 0; i < output.length; i++) {
      assertEquals("Byte " + i, TestAllTypesData.expectedOutput[i], output[i] & 0xff);
    }
  }

  @Test
  public void testRead() throws IOException {
    byte[] data = new byte[TestAllTypesData.expectedOutput.length];
    wire.writeTo(allTypes, data, 0, data.length);
    AllTypes parsed = wire.parseFrom(AllTypes.class, data);
    assertEquals(allTypes, parsed);

    assertEquals(Boolean.TRUE, allTypes.getExtension(Ext_all_types.ext_opt_bool));
    assertEquals(array(true), allTypes.getExtension(Ext_all_types.ext_rep_bool));
    assertEquals(array(true), allTypes.getExtension(Ext_all_types.ext_pack_bool));

  }

  @Test
  public void testReadNoExtension() throws IOException {
    byte[] data = new byte[TestAllTypesData.expectedOutput.length];
    wire.writeTo(allTypes, data, 0, data.length);
    AllTypes parsed = new Wire().parseFrom(AllTypes.class, data);
    assertFalse(allTypes.equals(parsed));
  }

  @Test
  public void testReadNonPacked() throws IOException {
    byte[] data = new byte[TestAllTypesData.nonPacked.length];
    for (int i = 0; i < TestAllTypesData.nonPacked.length; i++) {
      data[i] = (byte) TestAllTypesData.nonPacked[i];
    }
    AllTypes parsed = wire.parseFrom(AllTypes.class, data);
    assertEquals(allTypes, parsed);
  }

  @Test
  public void testToString() throws IOException {
    byte[] data = new byte[TestAllTypesData.expectedOutput.length];
    wire.writeTo(allTypes, data, 0, data.length);
    AllTypes parsed = wire.parseFrom(AllTypes.class, data);
    assertEquals(TestAllTypesData.expectedToString, parsed.toString());
  }
}