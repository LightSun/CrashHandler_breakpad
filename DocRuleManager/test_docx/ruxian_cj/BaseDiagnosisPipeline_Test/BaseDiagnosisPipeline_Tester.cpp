#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class BaseDiagnosisPipeline_Tester : public QObject
{ Q_OBJECT
public:
	BaseDiagnosisPipeline_Tester();
	~BaseDiagnosisPipeline_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_addDiagnosis_data();
	void testCase1_addDiagnosis();
	void testCase2_clearDiagnosis_data();
	void testCase2_clearDiagnosis();
	void testCase3_prparePipeline_data();
	void testCase3_prparePipeline();
	void testCase4_prparePipeline_data();
	void testCase4_prparePipeline();
	void testCase5_startPipeline_data();
	void testCase5_startPipeline();
	void testCase6_startPipeline_data();
	void testCase6_startPipeline();
	void testCase7_hangePipeline_data();
	void testCase7_hangePipeline();
	void testCase8_getHanged_data();
	void testCase8_getHanged();
	void testCase9_getHanged_data();
	void testCase9_getHanged();
	void testCase10_stopPipeline_data();
	void testCase10_stopPipeline();
	void testCase11_getDiagnosisPart_data();
	void testCase11_getDiagnosisPart();
	void testCase12_resetDataList_data();
	void testCase12_resetDataList();
	void testCase13_onInitCompleted_data();
	void testCase13_onInitCompleted();
	void testCase14_getDiagnosisPart_data();
	void testCase14_getDiagnosisPart();
	void testCase15_resetDataList_data();
	void testCase15_resetDataList();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
BaseDiagnosisPipeline_Tester::BaseDiagnosisPipeline_Tester()
{
}
BaseDiagnosisPipeline_Tester::~BaseDiagnosisPipeline_Tester()
{
}
void BaseDiagnosisPipeline_Tester::initTestCase()
{
}
void BaseDiagnosisPipeline_Tester::cleanupTestCase()
{
}
void BaseDiagnosisPipeline_Tester::testCase1_addDiagnosis_data()
{
}
void BaseDiagnosisPipeline_Tester::testCase1_addDiagnosis()
{
}
void BaseDiagnosisPipeline_Tester::testCase2_clearDiagnosis_data()
{
}
void BaseDiagnosisPipeline_Tester::testCase2_clearDiagnosis()
{
}
void BaseDiagnosisPipeline_Tester::testCase3_prparePipeline_data()
{
}
void BaseDiagnosisPipeline_Tester::testCase3_prparePipeline()
{
}
void BaseDiagnosisPipeline_Tester::testCase4_prparePipeline_data()
{
}
void BaseDiagnosisPipeline_Tester::testCase4_prparePipeline()
{
}
void BaseDiagnosisPipeline_Tester::testCase5_startPipeline_data()
{
}
void BaseDiagnosisPipeline_Tester::testCase5_startPipeline()
{
}
void BaseDiagnosisPipeline_Tester::testCase6_startPipeline_data()
{
}
void BaseDiagnosisPipeline_Tester::testCase6_startPipeline()
{
}
void BaseDiagnosisPipeline_Tester::testCase7_hangePipeline_data()
{
}
void BaseDiagnosisPipeline_Tester::testCase7_hangePipeline()
{
}
void BaseDiagnosisPipeline_Tester::testCase8_getHanged_data()
{
}
void BaseDiagnosisPipeline_Tester::testCase8_getHanged()
{
}
void BaseDiagnosisPipeline_Tester::testCase9_getHanged_data()
{
}
void BaseDiagnosisPipeline_Tester::testCase9_getHanged()
{
}
void BaseDiagnosisPipeline_Tester::testCase10_stopPipeline_data()
{
}
void BaseDiagnosisPipeline_Tester::testCase10_stopPipeline()
{
}
void BaseDiagnosisPipeline_Tester::testCase11_getDiagnosisPart_data()
{
}
void BaseDiagnosisPipeline_Tester::testCase11_getDiagnosisPart()
{
}
void BaseDiagnosisPipeline_Tester::testCase12_resetDataList_data()
{
}
void BaseDiagnosisPipeline_Tester::testCase12_resetDataList()
{
}
void BaseDiagnosisPipeline_Tester::testCase13_onInitCompleted_data()
{
}
void BaseDiagnosisPipeline_Tester::testCase13_onInitCompleted()
{
}
void BaseDiagnosisPipeline_Tester::testCase14_getDiagnosisPart_data()
{
}
void BaseDiagnosisPipeline_Tester::testCase14_getDiagnosisPart()
{
}
void BaseDiagnosisPipeline_Tester::testCase15_resetDataList_data()
{
}
void BaseDiagnosisPipeline_Tester::testCase15_resetDataList()
{
}
QTEST_MAIN(BaseDiagnosisPipeline_Tester)
#include "BaseDiagnosisPipeline_Tester.moc"
