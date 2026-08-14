#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class ByteBufferIO_Tester : public QObject
{ Q_OBJECT
public:
	ByteBufferIO_Tester();
	~ByteBufferIO_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_append_data();
	void testCase1_append();
	void testCase2_append_data();
	void testCase2_append();
	void testCase3_trim_data();
	void testCase3_trim();
	void testCase4_skip_data();
	void testCase4_skip();
	void testCase5_getByte_data();
	void testCase5_getByte();
	void testCase6_getInt_data();
	void testCase6_getInt();
	void testCase7_getShort_data();
	void testCase7_getShort();
	void testCase8_getLong_data();
	void testCase8_getLong();
	void testCase9_getUByte_data();
	void testCase9_getUByte();
	void testCase10_getUShort_data();
	void testCase10_getUShort();
	void testCase11_getUInt_data();
	void testCase11_getUInt();
	void testCase12_getULong_data();
	void testCase12_getULong();
	void testCase13_getBool_data();
	void testCase13_getBool();
	void testCase14_getFloat_data();
	void testCase14_getFloat();
	void testCase15_getDouble_data();
	void testCase15_getDouble();
	void testCase16_getData_data();
	void testCase16_getData();
	void testCase17_getRawString_data();
	void testCase17_getRawString();
	void testCase18_getString16_data();
	void testCase18_getString16();
	void testCase19_getString_data();
	void testCase19_getString();
	void testCase20_getString64_data();
	void testCase20_getString64();
	void testCase21_getListInt_data();
	void testCase21_getListInt();
	void testCase22_getMap_data();
	void testCase22_getMap();
	void testCase23_getLeftLength_data();
	void testCase23_getLeftLength();
	void testCase24_getLeftLength_data();
	void testCase24_getLeftLength();
	void testCase25_getLength_data();
	void testCase25_getLength();
	void testCase26_getLength_data();
	void testCase26_getLength();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
ByteBufferIO_Tester::ByteBufferIO_Tester()
{
}
ByteBufferIO_Tester::~ByteBufferIO_Tester()
{
}
void ByteBufferIO_Tester::initTestCase()
{
}
void ByteBufferIO_Tester::cleanupTestCase()
{
}
void ByteBufferIO_Tester::testCase1_append_data()
{
}
void ByteBufferIO_Tester::testCase1_append()
{
}
void ByteBufferIO_Tester::testCase2_append_data()
{
}
void ByteBufferIO_Tester::testCase2_append()
{
}
void ByteBufferIO_Tester::testCase3_trim_data()
{
}
void ByteBufferIO_Tester::testCase3_trim()
{
}
void ByteBufferIO_Tester::testCase4_skip_data()
{
}
void ByteBufferIO_Tester::testCase4_skip()
{
}
void ByteBufferIO_Tester::testCase5_getByte_data()
{
}
void ByteBufferIO_Tester::testCase5_getByte()
{
}
void ByteBufferIO_Tester::testCase6_getInt_data()
{
}
void ByteBufferIO_Tester::testCase6_getInt()
{
}
void ByteBufferIO_Tester::testCase7_getShort_data()
{
}
void ByteBufferIO_Tester::testCase7_getShort()
{
}
void ByteBufferIO_Tester::testCase8_getLong_data()
{
}
void ByteBufferIO_Tester::testCase8_getLong()
{
}
void ByteBufferIO_Tester::testCase9_getUByte_data()
{
}
void ByteBufferIO_Tester::testCase9_getUByte()
{
}
void ByteBufferIO_Tester::testCase10_getUShort_data()
{
}
void ByteBufferIO_Tester::testCase10_getUShort()
{
}
void ByteBufferIO_Tester::testCase11_getUInt_data()
{
}
void ByteBufferIO_Tester::testCase11_getUInt()
{
}
void ByteBufferIO_Tester::testCase12_getULong_data()
{
}
void ByteBufferIO_Tester::testCase12_getULong()
{
}
void ByteBufferIO_Tester::testCase13_getBool_data()
{
}
void ByteBufferIO_Tester::testCase13_getBool()
{
}
void ByteBufferIO_Tester::testCase14_getFloat_data()
{
}
void ByteBufferIO_Tester::testCase14_getFloat()
{
}
void ByteBufferIO_Tester::testCase15_getDouble_data()
{
}
void ByteBufferIO_Tester::testCase15_getDouble()
{
}
void ByteBufferIO_Tester::testCase16_getData_data()
{
}
void ByteBufferIO_Tester::testCase16_getData()
{
}
void ByteBufferIO_Tester::testCase17_getRawString_data()
{
}
void ByteBufferIO_Tester::testCase17_getRawString()
{
}
void ByteBufferIO_Tester::testCase18_getString16_data()
{
}
void ByteBufferIO_Tester::testCase18_getString16()
{
}
void ByteBufferIO_Tester::testCase19_getString_data()
{
}
void ByteBufferIO_Tester::testCase19_getString()
{
}
void ByteBufferIO_Tester::testCase20_getString64_data()
{
}
void ByteBufferIO_Tester::testCase20_getString64()
{
}
void ByteBufferIO_Tester::testCase21_getListInt_data()
{
}
void ByteBufferIO_Tester::testCase21_getListInt()
{
}
void ByteBufferIO_Tester::testCase22_getMap_data()
{
}
void ByteBufferIO_Tester::testCase22_getMap()
{
}
void ByteBufferIO_Tester::testCase23_getLeftLength_data()
{
}
void ByteBufferIO_Tester::testCase23_getLeftLength()
{
}
void ByteBufferIO_Tester::testCase24_getLeftLength_data()
{
}
void ByteBufferIO_Tester::testCase24_getLeftLength()
{
}
void ByteBufferIO_Tester::testCase25_getLength_data()
{
}
void ByteBufferIO_Tester::testCase25_getLength()
{
}
void ByteBufferIO_Tester::testCase26_getLength_data()
{
}
void ByteBufferIO_Tester::testCase26_getLength()
{
}
QTEST_MAIN(ByteBufferIO_Tester)
#include "ByteBufferIO_Tester.moc"
