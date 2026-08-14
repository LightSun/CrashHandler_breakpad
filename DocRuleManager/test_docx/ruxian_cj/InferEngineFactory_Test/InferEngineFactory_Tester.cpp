#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class InferEngineFactory_Tester : public QObject
{ Q_OBJECT
public:
	InferEngineFactory_Tester();
	~InferEngineFactory_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_create_data();
	void testCase1_create();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
InferEngineFactory_Tester::InferEngineFactory_Tester()
{
}
InferEngineFactory_Tester::~InferEngineFactory_Tester()
{
}
void InferEngineFactory_Tester::initTestCase()
{
}
void InferEngineFactory_Tester::cleanupTestCase()
{
}
void InferEngineFactory_Tester::testCase1_create_data()
{
}
void InferEngineFactory_Tester::testCase1_create()
{
}
QTEST_MAIN(InferEngineFactory_Tester)
#include "InferEngineFactory_Tester.moc"
