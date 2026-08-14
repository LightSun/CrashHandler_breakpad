cmake_minimum_required(VERSION 3.5)

project(ClsItem_Tester  LANGUAGES CXX)

set(CMAKE_INCLUDE_CURRENT_DIR ON)

set(CMAKE_AUTOUIC ON)
set(CMAKE_AUTOMOC ON)
set(CMAKE_AUTORCC ON)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
enable_testing()

file(GLOB_RECURSE CPP_SOURCES "*.cpp")
file(GLOB_RECURSE C_SOURCES "*.c")
file(GLOB_RECURSE HEADERS "*.h")
file(GLOB_RECURSE FORMS "*.ui")
file(GLOB_RECURSE RESOURCES "*.qrc")
find_package(Qt5 COMPONENTS Core Test REQUIRED)

add_test(NAME ClsItem_Tester COMMAND ClsItem_Tester)
add_executable(ClsItem_Tester ${CPP_SOURCES} ${C_SOURCES} ${HEADERS} ${FORMS} ${RESOURCES})
target_link_libraries(ClsItem_Tester Qt5::Core Qt5::Test)
