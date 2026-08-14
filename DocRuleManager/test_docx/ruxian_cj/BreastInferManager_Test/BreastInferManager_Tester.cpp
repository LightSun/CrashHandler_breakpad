#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class BreastInferManager_Tester : public QObject
{ Q_OBJECT
public:
	BreastInferManager_Tester();
	~BreastInferManager_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_setRecognizers_data();
	void testCase1_setRecognizers();
	void testCase2_getConfig_data();
	void testCase2_getConfig();
	void testCase3_setConfig_data();
	void testCase3_setConfig();
	void testCase4_clearMultiFrameData_data();
	void testCase4_clearMultiFrameData();
	void testCase5_infer_data();
	void testCase5_infer();
	void testCase6_infer_data();
	void testCase6_infer();
	void testCase7_processMultiFrames_data();
	void testCase7_processMultiFrames();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
BreastInferManager_Tester::BreastInferManager_Tester()
{
}
BreastInferManager_Tester::~BreastInferManager_Tester()
{
}
void BreastInferManager_Tester::initTestCase()
{
}
void BreastInferManager_Tester::cleanupTestCase()
{
}
void BreastInferManager_Tester::testCase1_setRecognizers_data()
{
}
void BreastInferManager_Tester::testCase1_setRecognizers()
{
}
void BreastInferManager_Tester::testCase2_getConfig_data()
{
}
void BreastInferManager_Tester::testCase2_getConfig()
{
}
void BreastInferManager_Tester::testCase3_setConfig_data()
{
}
void BreastInferManager_Tester::testCase3_setConfig()
{
}
void BreastInferManager_Tester::testCase4_clearMultiFrameData_data()
{
}
void BreastInferManager_Tester::testCase4_clearMultiFrameData()
{
}
void BreastInferManager_Tester::testCase5_infer_data()
{
}
void BreastInferManager_Tester::testCase5_infer()
{
}
void BreastInferManager_Tester::testCase6_infer_data()
{
}
void BreastInferManager_Tester::testCase6_infer()
{
}
void BreastInferManager_Tester::testCase7_processMultiFrames_data()
{
}
void BreastInferManager_Tester::testCase7_processMultiFrames()
{
}
QTEST_MAIN(BreastInferManager_Tester)
#include "BreastInferManager_Tester.moc"
