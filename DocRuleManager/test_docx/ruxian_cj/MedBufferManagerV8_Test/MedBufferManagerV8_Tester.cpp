#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class MedBufferManagerV8_Tester : public QObject
{ Q_OBJECT
public:
	MedBufferManagerV8_Tester();
	~MedBufferManagerV8_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_getTensorShape_data();
	void testCase1_getTensorShape();
	void testCase2_setDynamicShape_data();
	void testCase2_setDynamicShape();
	void testCase3_printDims_data();
	void testCase3_printDims();
	void testCase4_getInputTensorName0_data();
	void testCase4_getInputTensorName0();
	void testCase5_getOuputTensorName0_data();
	void testCase5_getOuputTensorName0();
	void testCase6_getDeviceBindings_data();
	void testCase6_getDeviceBindings();
	void testCase7_getDeviceBindings_data();
	void testCase7_getDeviceBindings();
	void testCase8_getDeviceBuffer_data();
	void testCase8_getDeviceBuffer();
	void testCase9_getHostBuffer_data();
	void testCase9_getHostBuffer();
	void testCase10_getHostBuffer_data();
	void testCase10_getHostBuffer();
	void testCase11_getHostBuffer_data();
	void testCase11_getHostBuffer();
	void testCase12_getHostBuffer_data();
	void testCase12_getHostBuffer();
	void testCase13_getInShapeCount_data();
	void testCase13_getInShapeCount();
	void testCase14_getOutShapeCount_data();
	void testCase14_getOutShapeCount();
	void testCase15_size_data();
	void testCase15_size();
	void testCase16_size_data();
	void testCase16_size();
	void testCase17_copyInputToDevice_data();
	void testCase17_copyInputToDevice();
	void testCase18_copyOutputToHost_data();
	void testCase18_copyOutputToHost();
	void testCase19_copyInputToDeviceAsync_data();
	void testCase19_copyInputToDeviceAsync();
	void testCase20_copyOutputToHostAsync_data();
	void testCase20_copyOutputToHostAsync();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
MedBufferManagerV8_Tester::MedBufferManagerV8_Tester()
{
}
MedBufferManagerV8_Tester::~MedBufferManagerV8_Tester()
{
}
void MedBufferManagerV8_Tester::initTestCase()
{
}
void MedBufferManagerV8_Tester::cleanupTestCase()
{
}
void MedBufferManagerV8_Tester::testCase1_getTensorShape_data()
{
}
void MedBufferManagerV8_Tester::testCase1_getTensorShape()
{
}
void MedBufferManagerV8_Tester::testCase2_setDynamicShape_data()
{
}
void MedBufferManagerV8_Tester::testCase2_setDynamicShape()
{
}
void MedBufferManagerV8_Tester::testCase3_printDims_data()
{
}
void MedBufferManagerV8_Tester::testCase3_printDims()
{
}
void MedBufferManagerV8_Tester::testCase4_getInputTensorName0_data()
{
}
void MedBufferManagerV8_Tester::testCase4_getInputTensorName0()
{
}
void MedBufferManagerV8_Tester::testCase5_getOuputTensorName0_data()
{
}
void MedBufferManagerV8_Tester::testCase5_getOuputTensorName0()
{
}
void MedBufferManagerV8_Tester::testCase6_getDeviceBindings_data()
{
}
void MedBufferManagerV8_Tester::testCase6_getDeviceBindings()
{
}
void MedBufferManagerV8_Tester::testCase7_getDeviceBindings_data()
{
}
void MedBufferManagerV8_Tester::testCase7_getDeviceBindings()
{
}
void MedBufferManagerV8_Tester::testCase8_getDeviceBuffer_data()
{
}
void MedBufferManagerV8_Tester::testCase8_getDeviceBuffer()
{
}
void MedBufferManagerV8_Tester::testCase9_getHostBuffer_data()
{
}
void MedBufferManagerV8_Tester::testCase9_getHostBuffer()
{
}
void MedBufferManagerV8_Tester::testCase10_getHostBuffer_data()
{
}
void MedBufferManagerV8_Tester::testCase10_getHostBuffer()
{
}
void MedBufferManagerV8_Tester::testCase11_getHostBuffer_data()
{
}
void MedBufferManagerV8_Tester::testCase11_getHostBuffer()
{
}
void MedBufferManagerV8_Tester::testCase12_getHostBuffer_data()
{
}
void MedBufferManagerV8_Tester::testCase12_getHostBuffer()
{
}
void MedBufferManagerV8_Tester::testCase13_getInShapeCount_data()
{
}
void MedBufferManagerV8_Tester::testCase13_getInShapeCount()
{
}
void MedBufferManagerV8_Tester::testCase14_getOutShapeCount_data()
{
}
void MedBufferManagerV8_Tester::testCase14_getOutShapeCount()
{
}
void MedBufferManagerV8_Tester::testCase15_size_data()
{
}
void MedBufferManagerV8_Tester::testCase15_size()
{
}
void MedBufferManagerV8_Tester::testCase16_size_data()
{
}
void MedBufferManagerV8_Tester::testCase16_size()
{
}
void MedBufferManagerV8_Tester::testCase17_copyInputToDevice_data()
{
}
void MedBufferManagerV8_Tester::testCase17_copyInputToDevice()
{
}
void MedBufferManagerV8_Tester::testCase18_copyOutputToHost_data()
{
}
void MedBufferManagerV8_Tester::testCase18_copyOutputToHost()
{
}
void MedBufferManagerV8_Tester::testCase19_copyInputToDeviceAsync_data()
{
}
void MedBufferManagerV8_Tester::testCase19_copyInputToDeviceAsync()
{
}
void MedBufferManagerV8_Tester::testCase20_copyOutputToHostAsync_data()
{
}
void MedBufferManagerV8_Tester::testCase20_copyOutputToHostAsync()
{
}
QTEST_MAIN(MedBufferManagerV8_Tester)
#include "MedBufferManagerV8_Tester.moc"
