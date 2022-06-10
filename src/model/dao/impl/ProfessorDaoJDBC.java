package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Statement;

import db.DB;
import db.DbException;
import model.dao.ProfessorDao;
import model.entities.Department;
import model.entities.Professor;

public class ProfessorDaoJDBC implements ProfessorDao {

		private Connection conn;
		
		public ProfessorDaoJDBC(Connection conn) {
			this.conn = conn;
		}
		
		@Override
		public void insert(Professor obj) {
			PreparedStatement st = null;
			try {
				st = conn.prepareStatement(
						"INSERT INTO professor "
						+ "(Name, Email, BirthDate, CPF, BaseSalary, DepartmentId) "
						+ "VALUES "
						+ "(?, ?, ?, ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);
				
				st.setString(1, obj.getName());
				st.setString(2, obj.getEmail());
				st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
				st.setInt(4, obj.getCpf());
				st.setDouble(5, obj.getBaseSalary());
				st.setInt(6, obj.getDepartment().getId());
				
				int rowsAffected = st.executeUpdate();
				
				if (rowsAffected > 0) {
					ResultSet rs = st.getGeneratedKeys();
					if (rs.next()) {
						int id = rs.getInt(1);
						obj.setId(id);
					}
					DB.closeResultSet(rs);
				}
				else {
					throw new DbException("Unexpected error! No rows affected!");
				}
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			finally {
				DB.closeStatement(st);
			}
		}

		@Override
		public void update(Professor obj) {
			PreparedStatement st = null;
			try {
				st = conn.prepareStatement(
						"UPDATE Professor "
						+ "SET Name = ?, Email = ?, BirthDate = ?, CPF = ?, BaseSalary = ?, DepartmentId = ? "
						+ "WHERE Id = ?");
				
				st.setString(1, obj.getName());
				st.setString(2, obj.getEmail());
				st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
				st.setInt(4, obj.getCpf());
				st.setDouble(5, obj.getBaseSalary());
				st.setInt(6, obj.getDepartment().getId());
				st.setInt(7, obj.getId());
				
				st.executeUpdate();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			finally {
				DB.closeStatement(st);
			}
		}

		@Override
		public void deleteById(Integer id) {
			PreparedStatement st = null;
			try {
				st = conn.prepareStatement("DELETE FROM professor WHERE Id = ?");
				
				st.setInt(1, id);
				
				st.executeUpdate();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			finally {
				DB.closeStatement(st);
			}
		}

		@Override
		public Professor findById(Integer id) {
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				st = conn.prepareStatement(
						"SELECT professor.*,department.Name as DepName "
						+ "FROM professor INNER JOIN department "
						+ "ON professor.DepartmentId = department.Id "
						+ "WHERE professor.Id = ?");
				
				st.setInt(1, id);
				rs = st.executeQuery();
				if (rs.next()) {
					Department dep = instantiateDepartment(rs);
					Professor obj = instantiateProfessor(rs, dep);
					return obj;
				}
				return null;
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			finally {
				DB.closeStatement(st);
				DB.closeResultSet(rs);
			}
		}

		private Professor instantiateProfessor(ResultSet rs, Department dep) throws SQLException {
			Professor obj = new Professor();
			obj.setId(rs.getInt("Id"));
			obj.setName(rs.getString("Name"));
			obj.setEmail(rs.getString("Email"));
			obj.setBaseSalary(rs.getDouble("BaseSalary"));
			obj.setBirthDate(rs.getDate("BirthDate"));
			obj.setCpf(rs.getInt("CPF"));
			obj.setDepartment(dep);
			return obj;
		}

		private Department instantiateDepartment(ResultSet rs) throws SQLException {
			Department dep = new Department();
			dep.setId(rs.getInt("DepartmentId"));
			dep.setName(rs.getString("DepName"));
			return dep;
		}

		@Override
		public List<Professor> findAll() {
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				st = conn.prepareStatement(
						"SELECT professor.*,department.Name as DepName "
						+ "FROM professor INNER JOIN department "
						+ "ON professor.DepartmentId = department.Id "
						+ "ORDER BY Name");
				
				rs = st.executeQuery();
				
				List<Professor> list = new ArrayList<>();
				Map<Integer, Department> map = new HashMap<>();
				
				while (rs.next()) {
					
					Department dep = map.get(rs.getInt("DepartmentId"));
					
					if (dep == null) {
						dep = instantiateDepartment(rs);
						map.put(rs.getInt("DepartmentId"), dep);
					}
					
					Professor obj = instantiateProfessor(rs, dep);
					list.add(obj);
				}
				return list;
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			finally {
				DB.closeStatement(st);
				DB.closeResultSet(rs);
			}
		}

		@Override
		public List<Professor> findByDepartment(Department department) {
			PreparedStatement st = null;
			ResultSet rs = null;
			try {
				st = conn.prepareStatement(
						"SELECT professor.*,department.Name as DepName "
						+ "FROM professor INNER JOIN department "
						+ "ON professor.DepartmentId = department.Id "
						+ "WHERE DepartmentId = ? "
						+ "ORDER BY Name");
				
				st.setInt(1, department.getId());
				
				rs = st.executeQuery();
				
				List<Professor> list = new ArrayList<>();
				Map<Integer, Department> map = new HashMap<>();
				
				while (rs.next()) {
					
					Department dep = map.get(rs.getInt("DepartmentId"));
					
					if (dep == null) {
						dep = instantiateDepartment(rs);
						map.put(rs.getInt("DepartmentId"), dep);
					}
					
					Professor obj = instantiateProfessor(rs, dep);
					list.add(obj);
				}
				return list;
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			finally {
				DB.closeStatement(st);
				DB.closeResultSet(rs);
			}
		}


}
