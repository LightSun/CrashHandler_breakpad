#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class OnnxInputParams_Tester : public QObject
{ Q_OBJECT
public:
	OnnxInputParams_Tester();
	~OnnxInputParams_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_getMaxBatchSize_data();
	void testCase1_getMaxBatchSize();
	void testCase2_getModuleCacheDir_data();
	void testCase2_getModuleCacheDir();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
OnnxInputParams_Tester::OnnxInputParams_Tester()
{
}
OnnxInputParams_Tester::~OnnxInputParams_Tester()
{
}
void OnnxInputParams_Tester::initTestCase()
{
}
void OnnxInputParams_Tester::cleanupTestCase()
{
}
void OnnxInputParams_Tester::testCase1_getMaxBatchSize_data()
{
}
void OnnxInputParams_Tester::testCase1_getMaxBatchSize()
{
}
void OnnxInputParams_Tester::testCase2_getModuleCacheDir_data()
{
}
void OnnxInputParams_Tester::testCase2_getModuleCacheDir()
{
}
QTEST_MAIN(OnnxInputParams_Tester)
#include "OnnxInputParams_Tester.moc"
