#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class TrtRecognizer_Tester : public QObject
{ Q_OBJECT
public:
	TrtRecognizer_Tester();
	~TrtRecognizer_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_build_data();
	void testCase1_build();
	void testCase2_build_data();
	void testCase2_build();
	void testCase3_infer_data();
	void testCase3_infer();
	void testCase4_infer_data();
	void testCase4_infer();
	void testCase5_setInferEngine_data();
	void testCase5_setInferEngine();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
TrtRecognizer_Tester::TrtRecognizer_Tester()
{
}
TrtRecognizer_Tester::~TrtRecognizer_Tester()
{
}
void TrtRecognizer_Tester::initTestCase()
{
}
void TrtRecognizer_Tester::cleanupTestCase()
{
}
void TrtRecognizer_Tester::testCase1_build_data()
{
}
void TrtRecognizer_Tester::testCase1_build()
{
}
void TrtRecognizer_Tester::testCase2_build_data()
{
}
void TrtRecognizer_Tester::testCase2_build()
{
}
void TrtRecognizer_Tester::testCase3_infer_data()
{
}
void TrtRecognizer_Tester::testCase3_infer()
{
}
void TrtRecognizer_Tester::testCase4_infer_data()
{
}
void TrtRecognizer_Tester::testCase4_infer()
{
}
void TrtRecognizer_Tester::testCase5_setInferEngine_data()
{
}
void TrtRecognizer_Tester::testCase5_setInferEngine()
{
}
QTEST_MAIN(TrtRecognizer_Tester)
#include "TrtRecognizer_Tester.moc"
