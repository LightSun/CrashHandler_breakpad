#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class BreastDiagnosisPipeline_Tester : public QObject
{ Q_OBJECT
public:
	BreastDiagnosisPipeline_Tester();
	~BreastDiagnosisPipeline_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_instance_data();
	void testCase1_instance();
	void testCase2_addDiagnosis_data();
	void testCase2_addDiagnosis();
	void testCase3_clearDiagnosis_data();
	void testCase3_clearDiagnosis();
	void testCase4_getDiagnosisPart_data();
	void testCase4_getDiagnosisPart();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
BreastDiagnosisPipeline_Tester::BreastDiagnosisPipeline_Tester()
{
}
BreastDiagnosisPipeline_Tester::~BreastDiagnosisPipeline_Tester()
{
}
void BreastDiagnosisPipeline_Tester::initTestCase()
{
}
void BreastDiagnosisPipeline_Tester::cleanupTestCase()
{
}
void BreastDiagnosisPipeline_Tester::testCase1_instance_data()
{
}
void BreastDiagnosisPipeline_Tester::testCase1_instance()
{
}
void BreastDiagnosisPipeline_Tester::testCase2_addDiagnosis_data()
{
}
void BreastDiagnosisPipeline_Tester::testCase2_addDiagnosis()
{
}
void BreastDiagnosisPipeline_Tester::testCase3_clearDiagnosis_data()
{
}
void BreastDiagnosisPipeline_Tester::testCase3_clearDiagnosis()
{
}
void BreastDiagnosisPipeline_Tester::testCase4_getDiagnosisPart_data()
{
}
void BreastDiagnosisPipeline_Tester::testCase4_getDiagnosisPart()
{
}
QTEST_MAIN(BreastDiagnosisPipeline_Tester)
#include "BreastDiagnosisPipeline_Tester.moc"
